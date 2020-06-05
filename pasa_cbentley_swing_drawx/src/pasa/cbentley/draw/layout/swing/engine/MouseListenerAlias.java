package pasa.cbentley.draw.layout.swing.engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import pasa.cbentley.draw.layout.swing.ctx.SwingDrawerCtx;
import pasa.cbentley.framework.drawx.src4.engine.GraphicsX;
import pasa.cbentley.framework.drawx.src4.tech.ITechGraphicsX;

/**
 * 
 * @author Charles Bentley
 *
 */
public class MouseListenerAlias implements MouseListener {

   protected final SwingDrawerCtx sdc;

   private JComponentDrawXFigure        ellipse;

   public MouseListenerAlias(SwingDrawerCtx sdc, JComponentDrawXFigure ellipse) {
      this.sdc = sdc;
      this.ellipse = ellipse;

   }

   public void mouseClicked(MouseEvent e) {
      sdc.toDLog().pFlow("", null, MouseListenerAlias.class, "mouseClicked");
   }

   public void mousePressed(MouseEvent e) {
      sdc.toDLog().pFlow("", null, MouseListenerAlias.class, "mousePressed");
      GraphicsX gx = ellipse.getGraphicsX();
      gx.getGraphics();
      gx.setFlagOptions(1, true);

      if (e.isAltDown()) {
         boolean gradientFlag = gx.toggleSwitchOff(ITechGraphicsX.SWITCHOFF_1_GRADIENT);
         sdc.toDLog().pFlow("gradientFlag=" + gradientFlag, null, MouseListenerAlias.class, "mousePressed");
      } else {
         //toggle alias
         
      }
   }

   public void mouseReleased(MouseEvent e) {
      sdc.toDLog().pFlow("", null, MouseListenerAlias.class, "mouseReleased");

   }

   public void mouseEntered(MouseEvent e) {
      sdc.toDLog().pFlow("", null, MouseListenerAlias.class, "v");

   }

   public void mouseExited(MouseEvent e) {
      sdc.toDLog().pFlow("", null, MouseListenerAlias.class, "mouseExited");
   }

}
