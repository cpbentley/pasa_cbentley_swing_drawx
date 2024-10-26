package pasa.cbentley.draw.layout.swing.demo;

import pasa.cbentley.core.src4.ctx.ConfigUDef;
import pasa.cbentley.core.src4.ctx.IConfigU;
import pasa.cbentley.core.swing.ctx.SwingCoreCtx;
import pasa.cbentley.draw.layout.swing.ctx.SwingDrawerCtx;
import pasa.cbentley.framework.core.draw.swing.ctx.CoreDrawSwingCtx;
import pasa.cbentley.framework.drawx.src4.ctx.DrwCtx;
import pasa.cbentley.layouter.swing.demo.RunLayouterDemoSwingAbstract;

/**
 * Demo of using the Layouter and the Drawer directly on Swing without using the Bentley framework.
 * 
 * @author Charles Bentley
 *
 */
public abstract class RunSwingDrawerAbstract extends RunLayouterDemoSwingAbstract {

   protected final DrwCtx           dc;

   protected final CoreDrawSwingCtx dsc;

   protected final SwingDrawerCtx   sdc;

   public RunSwingDrawerAbstract() {
      this(null);
   }

   public RunSwingDrawerAbstract(IConfigU config) {
      super((config == null) ? new ConfigUDef() : config);

      SwingCoreCtx scc = slc.getSwingCtx();
      dsc = new CoreDrawSwingCtx(scc, boc);
      dc = new DrwCtx(dsc, slc);

      sdc = new SwingDrawerCtx(dc, dsc, slc);
   }

}
