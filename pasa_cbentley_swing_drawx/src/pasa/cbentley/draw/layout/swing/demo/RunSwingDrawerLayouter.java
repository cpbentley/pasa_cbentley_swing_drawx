package pasa.cbentley.draw.layout.swing.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.objects.color.ITechGradient;
import pasa.cbentley.core.src4.interfaces.C;
import pasa.cbentley.core.src4.utils.ColorUtils;
import pasa.cbentley.draw.layout.swing.ctx.SwingDrawerCtx;
import pasa.cbentley.draw.layout.swing.engine.JComponentDrawXFigure;
import pasa.cbentley.draw.layout.swing.engine.MouseListenerAlias;
import pasa.cbentley.framework.coredraw.src4.interfaces.ITechFont;
import pasa.cbentley.layouter.src4.engine.LayoutWillListenerAdapter;
import pasa.cbentley.layouter.src4.engine.PozerFactory;
import pasa.cbentley.layouter.src4.engine.Zer2DPozer;
import pasa.cbentley.layouter.src4.interfaces.ILayoutable;
import pasa.cbentley.layouter.src4.tech.ITechLayout;
import pasa.cbentley.layouter.swing.engine.ConfiguratorForSwing;
import pasa.cbentley.layouter.swing.engine.JPanelLayoutable;

/**
 * Demo of using the Layouter and the Drawer directly on Swing without using the Bentley framework.
 * 
 * @author Charles Bentley
 *
 */
public class RunSwingDrawerLayouter extends RunSwingDrawerAbstract {

   public RunSwingDrawerLayouter() {
      
   }
   public static void main(String[] args) throws IOException {
      RunSwingDrawerLayouter run = new RunSwingDrawerLayouter();
      run.run();
   }


   public void buildDemo(JPanelLayoutable panels) {
      ConfiguratorForSwing panel = panels.getConfigurator();

      ByteObject sizerW = slc.getSizerFactory().getSizerRatio100(ITechLayout.ETALON_4_PARENT, 30);
      ByteObject sizerH = slc.getSizerFactory().getSizerRatio100(ITechLayout.ETALON_4_PARENT, 40);
      ByteObject sizer10 = slc.getSizerFactory().getSizerRatio100(ITechLayout.ETALON_4_PARENT, 10);
      ByteObject sizer30 = slc.getSizerFactory().getSizerRatio100(ITechLayout.ETALON_4_PARENT, 30);
      PozerFactory pozerFac = slc.getFactoryPozer();
      ByteObject pozerX = pozerFac.getPozerCenterToCenter();
      ByteObject pozerY = pozerFac.getPozerCenterToCenter();
      ByteObject pozerEndCenter = pozerFac.getPozerEndToCenter();
      ByteObject pozerXRightToRight = pozerFac.getPozerBottomRight();
      ByteObject pozerTopToTop = pozerFac.getPozerTopToTop();
      ByteObject pozerCenterToTop = pozerFac.getPozerCenterToTopLeft();
      ByteObject pozerCenterToRight = pozerFac.getPozerCenterToBotRight();
      ByteObject pozerYTop = pozerFac.getPozerTopLeft();
      Zer2DPozer top2TopRight2RightParent = new Zer2DPozer(slc, pozerXRightToRight, pozerTopToTop);
      Zer2DPozer centerRightParent = new Zer2DPozer(slc, pozerXRightToRight, pozerYTop);
      Zer2DPozer pozerEndToCenterTopToTopParent = new Zer2DPozer(slc, pozerEndCenter, pozerTopToTop);
      ByteObject sizer40 = slc.getSizerFactory().getSizerPix(40);
      ByteObject sizer60 = slc.getSizerFactory().getSizerPix(60);
      ByteObject sizerRatio50 = slc.getSizerFactory().getSizerRatio100(ITechLayout.ETALON_4_PARENT, 50);

      int color1 = ColorUtils.getRGBInt(140, 180, 40);
      int color2 = ColorUtils.getRGBInt(040, 180, 240);
      ByteObject gradient = dc.getGradientFactory().getGradient(color2, 100, ITechGradient.GRADIENT_TYPE_RECT_00_SQUARE);

      ByteObject figBorder = dc.getFigureFactory().getFigBorder(5, color2);
      //arcs can be sizers
      ByteObject figRect = dc.getFigureFactory().getFigRect(color1, 10, 10, gradient);

      //figure box context module registered
      //#debug
      uc.toDLog().pTest("Green Figure", figBorder, RunSwingDrawerLayouter.class, "main", uc.LVL_05_FINE, true);

      JComponentDrawXFigure green = new JComponentDrawXFigure(sdc);
      green.setName("green");
      green.setSizer(sizerW, sizerH);
      green.setPozer(pozerX, pozerY);
      green.setFigure(figRect);

      JComponentDrawXFigure border = new JComponentDrawXFigure(sdc);
      border.setName("border");
      border.setSizer(sizerW, sizer10);
      border.setPozer(pozerX, pozerTopToTop);
      border.setFigure(figBorder);

      JComponentDrawXFigure triangle = new JComponentDrawXFigure(sdc);
      triangle.setName("triangle");
      triangle.setSizer(sizerW, sizer30);
      triangle.setPozer(pozerFac.getPozerStartToStart(), pozerFac.getPozerBotToBot());

      ByteObject gradientTrig = dc.getGradientFactory().getGradient(color2, 100, ITechGradient.GRADIENT_TYPE_TRIG_08_NORMAL);

      ByteObject figTriangle = dc.getFigureFactory().getFigTriangleType(color1, C.TYPE_00_TOP, gradientTrig);

      triangle.setFigure(figTriangle);

      JComponentDrawXFigure ellipse = new JComponentDrawXFigure(sdc);
      ellipse.setName("ellipse");
      ellipse.setSizer(sizerW, sizer30);
      ellipse.setPozer(pozerFac.getPozerEndToEnd(), pozerFac.getPozerBotToBot());
      ByteObject gradientEllipse = dc.getGradientFactory().getGradient(color2, 100, ITechGradient.GRADIENT_TYPE_ELLIPSE_00_NORMAL);
      ByteObject figEllipse = dc.getFigureFactory().getFigEllipse(color1, gradientEllipse);
      ellipse.setFigure(figEllipse);

      MouseListenerAlias mouseAliasEllipse = new MouseListenerAlias(sdc, ellipse);
      ellipse.addMouseListener(mouseAliasEllipse);

      JComponentDrawXFigure losange = new JComponentDrawXFigure(sdc);
      losange.setName("losange");
      losange.setSizer(sizerW, sizer30);
      losange.setPozer(pozerFac.getPozerStartToStart(), pozerFac.getPozerTopToTop());
      ByteObject gradientLosange = dc.getGradientFactory().getGradient(color2, 100, ITechGradient.GRADIENT_TYPE_LOSANGE_2_FULLHORIZ);
      int overstep = 0;
      boolean isHoriz = false;
      boolean isPap = false;
      boolean isCountour = false;
      ByteObject figLosange = dc.getFigureFactory().getFigLosange(color1, overstep, isHoriz, isPap, isCountour, gradientLosange);
      losange.setFigure(figLosange);

      MouseListenerAlias mouseAliasLosange = new MouseListenerAlias(sdc, losange);
      losange.addMouseListener(mouseAliasLosange);

      JComponentDrawXFigure hello = new JComponentDrawXFigure(sdc);
      hello.setName("hello");
      hello.setSizer(sizerW, sizer30);
      hello.setPozer(pozerFac.getPozerEndToEnd(), pozerFac.getPozerTopToTop());
      int face = ITechFont.FACE_MONOSPACE;
      int style = ITechFont.STYLE_BOLD;
      int size = ITechFont.SIZE_3_MEDIUM;
      ByteObject figHello = dc.getFigureFactory().getFigString("Hello!", face, style, size, color1);
      hello.setFigure(figHello);

      panel.addLayoutableOnTop(green);
      panel.addLayoutableOnTop(border);
      panel.addLayoutableOnTop(triangle);
      panel.addLayoutableOnTop(ellipse);
      panel.addLayoutableOnTop(losange);
      panel.addLayoutableOnTop(hello);

      JMenuBar menuBar = new JMenuBar();
      JMenu menu = new JMenu("Actions");
      JMenuItem actionToggleAliasDefault = new JMenuItem("Toggle Alias Default");
      JMenuItem actionToggleAliasMaster = new JMenuItem("Toggle Alias Master");
      actionToggleAliasDefault.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            boolean b = dsc.toogleAlias();
            if (b) {
               actionToggleAliasDefault.setText("Toggle Alias : ON");
            } else {
               actionToggleAliasDefault.setText("Toggle Alias : OFF");
            }
         }
      });
      actionToggleAliasMaster.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            boolean b = dsc.toogleAliasForce();
            if (b) {
               actionToggleAliasMaster.setText("Toggle FAlias : ON");
            } else {
               actionToggleAliasMaster.setText("Toggle FAlias : OFF");
            }
         }
      });
      menu.add(actionToggleAliasDefault);
      menu.add(actionToggleAliasMaster);
      menuBar.add(menu);
      frame.setJMenuBar(menuBar);
      
      
      
      slc.toStringSetDebugBreaks(new LayoutWillListenerAdapter() {

         public void layoutWillComputePositions(ILayoutable layoutable) {
            if (layoutable == green) {
               isBreak = true;
            }
         }

         public void layoutWillComputePositionX(ILayoutable layoutable) {

         }

         public void layoutWillComputePositionY(ILayoutable layoutable) {

         }

         public void layoutWillComputeSizeH(ILayoutable layoutable) {

         }

         public void layoutWillComputeSizes(ILayoutable layoutable) {
            if (layoutable == green) {
               isBreak = true;
            }
         }

         public void layoutWillComputeSizeW(ILayoutable layoutable) {
            if (layoutable == green) {
               isBreak = true;
            }
         }
      });

   }

}
