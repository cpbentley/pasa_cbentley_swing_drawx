package pasa.cbentley.draw.layout.swing.ctx;

import pasa.cbentley.core.src4.ctx.ACtx;
import pasa.cbentley.draw.layout.swing.engine.JComponentDrawXFigure;
import pasa.cbentley.framework.coredraw.src4.ctx.CoreDrawCtx;
import pasa.cbentley.framework.coredraw.swing.ctx.CoreDrawSwingCtx;
import pasa.cbentley.framework.drawx.src4.ctx.DrwCtx;
import pasa.cbentley.framework.drawx.src4.engine.GraphicsX;
import pasa.cbentley.layouter.src4.ctx.LayouterCtx;
import pasa.cbentley.layouter.swing.ctx.SwingLayouterCtx;

/**
 * Library for drawing figures from {@link DrwCtx} on a {@link GraphicsX} using the {@link LayouterCtx} swing adapter.
 * 
 * <li> {@link JComponentDrawXFigure}
 * 
 * @author Charles Bentley
 *
 */
public class SwingDrawerCtx extends ACtx {

   protected final DrwCtx           drc;

   protected final CoreDrawSwingCtx dsc;

   protected final SwingLayouterCtx slc;

   public SwingDrawerCtx(DrwCtx drc, CoreDrawSwingCtx dsc, SwingLayouterCtx slc) {
      super(drc.getUC());
      this.drc = drc;
      this.dsc = dsc;
      this.slc = slc;
   }

   public SwingLayouterCtx getSwingLayouterCtx() {
      return slc;
   }

   public DrwCtx getDrwContext() {
      return drc;
   }

   public SwingLayouterCtx getSLC() {
      return slc;
   }

   public CoreDrawCtx getCoreDrawCtx() {
      return drc.getCoreDrawCtx();
   }

   public CoreDrawSwingCtx getCoreDrawSwingCtx() {
      return dsc;
   }

   public int getCtxID() {
      return 449;
   }
}
