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
public class RunSwingDrawerCards extends RunSwingDrawerAbstract {

   public RunSwingDrawerCards() {
      
   }
   public static void main(String[] args) throws IOException {
      RunSwingDrawerCards run = new RunSwingDrawerCards();
      run.run();
   }


   public void buildDemo(JPanelLayoutable panels) {
      ConfiguratorForSwing panel = panels.getConfigurator();

      ByteObject sizerW = slc.getSizerFactory().getSizerRatio100(30, ITechLayout.ETALON_4_PARENT);
      ByteObject sizerH = slc.getSizerFactory().getSizerRatio100(40, ITechLayout.ETALON_4_PARENT);
      ByteObject sizer10 = slc.getSizerFactory().getSizerRatio100(10, ITechLayout.ETALON_4_PARENT);
      ByteObject sizer30 = slc.getSizerFactory().getSizerRatio100(30, ITechLayout.ETALON_4_PARENT);
      PozerFactory pozerFac = slc.getFactoryPozer();
      ByteObject pozerX = pozerFac.getPozerCenterToCenter();
      ByteObject pozerY = pozerFac.getPozerCenterToCenter();
      ByteObject pozerEndCenter = pozerFac.getPozerEndToCenter();
      ByteObject pozerXRightToRight = pozerFac.getPozerRightToRight();
      ByteObject pozerTopToTop = pozerFac.getPozerTopToTop();
      
      ByteObject pozerCenterToTop = pozerFac.getPozerCenterToTopLeft();
      ByteObject pozerCenterToRight = pozerFac.getPozerCenterToBotRight();
      ByteObject pozerYTop = pozerFac.getPozerTopLeft();
      Zer2DPozer top2TopRight2RightParent = new Zer2DPozer(slc, pozerXRightToRight, pozerTopToTop);
      Zer2DPozer centerRightParent = new Zer2DPozer(slc, pozerXRightToRight, pozerYTop);
      Zer2DPozer pozerEndToCenterTopToTopParent = new Zer2DPozer(slc, pozerEndCenter, pozerTopToTop);
      ByteObject sizer40 = slc.getSizerFactory().getSizerPixel(40);
      ByteObject sizer60 = slc.getSizerFactory().getSizerPixel(60);
      ByteObject sizerRatio50 = slc.getSizerFactory().getSizerRatio100(50, ITechLayout.ETALON_4_PARENT);

      int color1 = ColorUtils.getRGBInt(140, 180, 40);
      int color2 = ColorUtils.getRGBInt(040, 180, 240);
      
      int colorBlack = ColorUtils.getRGBInt(040, 00, 040);
      int colorRed = ColorUtils.getRGBInt(240, 00, 040);
      
      ByteObject gradient = dc.getGradientFactory().getGradient(color2, 100, ITechGradient.GRADIENT_TYPE_RECT_00_SQUARE);


      JComponentDrawXFigure trefle = new JComponentDrawXFigure(sdc);
      trefle.setName("trefle");
      trefle.setSizer(sizerW, sizer10);
      trefle.setPozer(pozerXRightToRight, pozerTopToTop);

      ByteObject figRect = dc.getFigureFactory().getFigRect(colorBlack, 10, 10, gradient);
      trefle.setFigure(figRect);

      
      JComponentDrawXFigure pique = new JComponentDrawXFigure(sdc);
      pique.setName("pique");
      pique.setSizer(sizerW, sizer30);
      
      pique.setPozer(pozerFac.getPozerStartToStart(), pozerFac.getPozerBotToBot());

      ByteObject gradientTrig = dc.getGradientFactory().getGradient(color2, 100, ITechGradient.GRADIENT_TYPE_TRIG_08_NORMAL);
      ByteObject figTriangle = dc.getFigureFactory().getFigTriangleType(colorRed, C.TYPE_00_TOP, gradientTrig);

      pique.setFigure(figTriangle);

      
      JComponentDrawXFigure coeur = new JComponentDrawXFigure(sdc);
      coeur.setName("coeur");
      coeur.setSizer(sizerW, sizer30);
      coeur.setPozer(pozerFac.getPozerEndToEnd(), pozerFac.getPozerBotToBot());
      ByteObject gradientEllipse = dc.getGradientFactory().getGradient(colorRed, 100, ITechGradient.GRADIENT_TYPE_ELLIPSE_00_NORMAL);
      ByteObject figEllipse = dc.getFigureFactory().getFigEllipse(color1, gradientEllipse);
      coeur.setFigure(figEllipse);

      MouseListenerAlias mouseAliasEllipse = new MouseListenerAlias(sdc, coeur);
      coeur.addMouseListener(mouseAliasEllipse);

      JComponentDrawXFigure carreau = new JComponentDrawXFigure(sdc);
      carreau.setName("carreau");
      carreau.setSizer(sizerW, sizer30);
      //use a pozer Factory create them. Not very elegant
      carreau.setPozer(pozerFac.getPozerStartToStart(), pozerFac.getPozerTopToTop());
      ByteObject gradientLosange = dc.getGradientFactory().getGradient(color2, 100, ITechGradient.GRADIENT_TYPE_LOSANGE_2_FULLHORIZ);
      int overstep = 0;
      boolean isHoriz = false;
      boolean isPap = false;
      boolean isCountour = false;
      ByteObject figLosange = dc.getFigureFactory().getFigLosange(color1, overstep, isHoriz, isPap, isCountour, gradientLosange);
      carreau.setFigure(figLosange);

      MouseListenerAlias mouseAliasLosange = new MouseListenerAlias(sdc, carreau);
      carreau.addMouseListener(mouseAliasLosange);

      JComponentDrawXFigure numbers = new JComponentDrawXFigure(sdc);
      numbers.setName("numbers");
      numbers.setSizer(sizerW, sizer30);
      numbers.setPozer(pozerFac.getPozerCenterToCenter(), pozerFac.getPozerCenterToCenter());
      int face = ITechFont.FACE_01_MONOSPACE;
      int style = ITechFont.STYLE_1_BOLD;
      int size = ITechFont.SIZE_5_HUGE;
      ByteObject figHello = dc.getFigureFactory().getFigString("1 2 3 4 5 6 7 8 9 0", face, style, size, color1);
      numbers.setFigure(figHello);

      panel.addLayoutableOnTop(trefle);
      panel.addLayoutableOnTop(pique);
      panel.addLayoutableOnTop(coeur);
      panel.addLayoutableOnTop(carreau);
      panel.addLayoutableOnTop(numbers);

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
            if (layoutable == carreau) {
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
            if (layoutable == carreau) {
               isBreak = true;
            }
         }

         public void layoutWillComputeSizeW(ILayoutable layoutable) {
            if (layoutable == carreau) {
               isBreak = true;
            }
         }
      });

   }

}
