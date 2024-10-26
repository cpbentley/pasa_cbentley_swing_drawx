package pasa.cbentley.draw.layout.swing.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import pasa.cbentley.draw.layout.swing.ctx.SwingDrawerCtx;
import pasa.cbentley.framework.core.draw.swing.engine.GraphicsSwing;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechGraphics;
import pasa.cbentley.framework.drawx.src4.engine.GraphicsX;
import pasa.cbentley.layouter.swing.engine.JComponentLayoutable;

/**
 * 
 * @author Charles Bentley
 *
 */
public abstract class JComponentDrawXAbstract extends JComponentLayoutable {

   protected final SwingDrawerCtx ssd;

   private GraphicsX              gx;

   private GraphicsSwing          gswing;

   public JComponentDrawXAbstract(SwingDrawerCtx sdc) {
      super(sdc.getSwingLayouterCtx());
      this.ssd = sdc;

      gx = new GraphicsX(ssd.getDrwContext());
      gswing = new GraphicsSwing(ssd.getCoreDrawSwingCtx());
   }

   public GraphicsX getGraphicsX() {
      return gx;
   }

   @Override
   public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      try {
         gswing.setGraphics2D(g2);
         gx.setGraphics(gswing);

         paint(gx);
      } catch (Exception e) {
         String msg = e.getMessage();
         String print = e.getClass().getName() + " " + msg;
         g2.setColor(Color.BLACK);
         g2.fillRect(0, 0, getWidth(), getHeight());
         g2.setColor(Color.RED);
         g2.drawString(print, 5, 25);

         e.printStackTrace();
      }
   }

   public void paint(IGraphics g) {
      // Setup the graphics object as per the spec.
      g.setTranslate(-g.getTranslateX(), -g.getTranslateY());
      g.setClip(0, 0, getWidth(), getHeight());
      g.setColor(0xff000000); // black
      g.setFont(ssd.getCoreDrawCtx().getFontFactory().getDefaultFont());
      g.setStrokeStyle(ITechGraphics.SOLID);

      //we need an object with Graphi
      paint(gx);
   }

   public abstract void paint(GraphicsX gx);
}
