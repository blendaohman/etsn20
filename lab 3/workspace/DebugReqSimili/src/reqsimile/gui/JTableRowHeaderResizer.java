package reqsimile.gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ContainerListener;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.JTable;
import javax.swing.event.MouseInputAdapter;

import java.io.Serializable;


public class JTableRowHeaderResizer
    extends MouseInputAdapter
    implements Serializable, ContainerListener
{
    /** Backward serializable compatibility */
	private static final long serialVersionUID = 1L;
    
    private JScrollPane pane;
    private JViewport   viewport;
    private JTable      rowHeader;
    private Component   corner;
    private JTable      view;

    private boolean enabled;
    

    public JTableRowHeaderResizer(JScrollPane pane)
    {
        this.pane = pane;

        this.pane.addContainerListener(this);
    }
    
    public void setEnabled(boolean what)
    {
        if (enabled == what)
            return;

        enabled = what;
        
        if (enabled)
            addListeners();
        else
            removeListeners();
    }

    protected void addListeners()
    {
        if (corner != null)
        {
            corner.addMouseListener(this);
            corner.addMouseMotionListener(this);
        }
    }

    protected void removeListeners()
    {
        if (corner != null)
        {
            corner.removeMouseListener(this);
            corner.removeMouseMotionListener(this);
        }
    }

    protected void lookupComponents()
    {
        this.view = (JTable)pane.getViewport().getView();
        this.viewport = pane.getRowHeader();
        if (viewport == null)
            this.rowHeader = null;
        else
            this.rowHeader = (JTable)viewport.getView();
        this.corner = pane.getCorner(JScrollPane.UPPER_LEFT_CORNER);
    }

    
    public void componentAdded(ContainerEvent e)
    {
        componentRemoved(e);
    }

    public void componentRemoved(ContainerEvent e)
    {
        if (enabled)
            removeListeners();

        lookupComponents();
        
        if (enabled)
            addListeners();
    }
    

    private boolean active;
    
    private int startX,        startWidth;
    
    private int minWidth, maxWidth;
    
    private Dimension size;
    
    private static final int PIXELS = 10;
    
    private static final Cursor RESIZE_CURSOR = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
    
    private Cursor oldCursor;


    public void mouseExited(MouseEvent e)
    {
        if (oldCursor != null)
        {
            corner.setCursor(oldCursor);
            oldCursor = null;
        }
    }

    public void mouseEntered(MouseEvent e)
    {
        mouseMoved(e);
    }

    public void mouseMoved(MouseEvent e)
    {
        if (corner.getWidth() - e.getX() <= PIXELS)
        {
            if (oldCursor == null)
            {
                oldCursor = corner.getCursor();
                corner.setCursor(RESIZE_CURSOR);
            }
        }
        else if (oldCursor != null)
        {
            corner.setCursor(oldCursor);
            oldCursor = null;
        }
    }
    
    
    public void mousePressed(MouseEvent e)
    {
        startX = e.getX();
        
        startWidth = rowHeader.getWidth();
        
        if (startWidth - startX > PIXELS)
            return;
        
        active = true;
        
        if (oldCursor == null)
        {
            oldCursor = corner.getCursor();
            corner.setCursor(RESIZE_CURSOR);
        }

        minWidth = rowHeader.getMinimumSize().width;
        maxWidth = rowHeader.getMaximumSize().width;
    }
    
    public void mouseReleased(MouseEvent e)
    {
        active = false;
    }
    
    public void mouseDragged(MouseEvent e)
    {
        if (!active)
            return;
        
        size = viewport.getPreferredSize();     

        int newX = e.getX();
        
        size.width = startWidth + e.getX() - startX;
        
        if (size.width < minWidth)
            size.width = minWidth;
        else if (size.width > maxWidth)
            size.width = maxWidth;

        viewport.setPreferredSize(size);

        // Change all columns         
//        for(int i=0; i<rowHeader.getRowCount(); i++) {
//        	RowHeaderRenderer rhr = (RowHeaderRenderer)(rowHeader.getCellRenderer(i, 0));
//        	rhr.getColumnModel().getColumn(0).setPreferredWidth(size.width);
//        }

//        Application.getGUI().adjustTableRowHeaderWidth(0);
        //rowHeader.setPreferredSize(size);
        rowHeader.getColumnModel().getColumn(0).setPreferredWidth(size.width);
        //view.doLayout();
        
        pane.revalidate();
    }
}