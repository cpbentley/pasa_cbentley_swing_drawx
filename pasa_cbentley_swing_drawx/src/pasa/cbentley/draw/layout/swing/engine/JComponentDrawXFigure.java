package pasa.cbentley.draw.layout.swing.engine;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.draw.layout.swing.ctx.SwingDrawerCtx;
import pasa.cbentley.framework.drawx.src4.engine.GraphicsX;
import pasa.cbentley.framework.drawx.src4.factories.FigureFactory;

/**
 * Draws a set of Figures from {@link FigureFactory}
 * @author Charles Bentley
 *
 */
public class JComponentDrawXFigure extends JComponentDrawXAbstract {

   private ByteObject figure;
   
   public JComponentDrawXFigure(SwingDrawerCtx sdc) {
      super(sdc);
   }

   public void paint(GraphicsX gx) {
      if(figure != null) {
         int w = getWidth();
         int h = getHeight();
         gx.drawFigure(figure, 0 , 0, w, h);
      }
   }

   public ByteObject getFigure() {
      return figure;
   }

   public void setFigure(ByteObject figure) {
      this.figure = figure;
   }

}
