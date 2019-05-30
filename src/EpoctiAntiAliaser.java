import java.awt.*;
import java.awt.image.BufferedImage;

class EpoctiAntiAliaser{
	private BufferedImage img;
	private int chkRgb, r, g, b, a;

	EpoctiAntiAliaser(int r, int g, int b, int a, BufferedImage img){
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		chkRgb = new Color(r, g, b, a).getRGB();
		this.img = img;
	}

	BufferedImage antiAlias(){
		// TODO: Make it so that, if a non 0-alpha pixel needs to be edited, do so by adding the checking color on top of the current pixel
		BufferedImage aaImg = img;
		for (int y = 0; y < aaImg.getHeight(); y++){
			for (int x = 0; x < aaImg.getWidth(); x++){
				if (aaImg.getRGB(x, y) != chkRgb){
					if (x > 0 && y > 0){
						if ((aaImg.getRGB(x, y - 1) == chkRgb) && (aaImg.getRGB(x - 1, y) == chkRgb)){
							Color curCol = new Color(aaImg.getRGB(x, y), true);
							if (curCol.getAlpha() == 0)
								aaImg.setRGB(x, y, new Color(r, g, b, 74).getRGB());
							else
								aaImg.setRGB(x, y, new Color((int) (curCol.getRed() * .7), (int) (curCol.getGreen() * .7), (int) (curCol.getBlue() * .7), curCol.getAlpha()).getRGB());
						}
					}
					if (x < aaImg.getWidth() - 1 && y < aaImg.getHeight() - 1){
						if ((aaImg.getRGB(x, y + 1) == chkRgb) && (aaImg.getRGB(x + 1, y) == chkRgb)){
							Color curCol = new Color(aaImg.getRGB(x, y), true);
							if (curCol.getAlpha() == 0)
								aaImg.setRGB(x, y, new Color(r, g, b, 74).getRGB());
							else
								aaImg.setRGB(x, y, new Color((int) (curCol.getRed() * .7), (int) (curCol.getGreen() * .7), (int) (curCol.getBlue() * .7), curCol.getAlpha()).getRGB());
						}
					}
					if (y > 0 && x < aaImg.getWidth() - 1){
						if ((aaImg.getRGB(x, y - 1) == chkRgb) && (aaImg.getRGB(x + 1, y) == chkRgb)){
							Color curCol = new Color(aaImg.getRGB(x, y), true);
							if (curCol.getAlpha() == 0)
								aaImg.setRGB(x, y, new Color(r, g, b, 74).getRGB());
							else
								aaImg.setRGB(x, y, new Color((int) (curCol.getRed() * .7), (int) (curCol.getGreen() * .7), (int) (curCol.getBlue() * .7), curCol.getAlpha()).getRGB());
						}
					}
					if (x > 0 && y < aaImg.getHeight() - 1){
						if ((aaImg.getRGB(x, y + 1) == chkRgb) && (aaImg.getRGB(x - 1, y) == chkRgb)){
							Color curCol = new Color(aaImg.getRGB(x, y), true);
							if (curCol.getAlpha() == 0)
								aaImg.setRGB(x, y, new Color(r, g, b, 74).getRGB());
							else
								aaImg.setRGB(x, y, new Color((int) (curCol.getRed() * .7), (int) (curCol.getGreen() * .7), (int) (curCol.getBlue() * .7), curCol.getAlpha()).getRGB());
						}
					}
				}
			}
		}
		return aaImg;
	}
}
