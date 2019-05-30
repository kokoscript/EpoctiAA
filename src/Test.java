import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/* 	This is an example of a program that demonstrates usage of the EpoctiAntiAliaser.
	It will load an image named "in.png", and output an anti-aliased version to "out.png".
 */

public class Test{
	public static void main(String[] args){
		System.out.println("EpoctiAA - kokoscript");
		// get checking color values from args
		int r = Integer.parseInt(args[0]), g = Integer.parseInt(args[1]), b = Integer.parseInt(args[2]), a = Integer.parseInt(args[3]);
		try {
			// Read in image
			BufferedImage img = ImageIO.read(new File("in.png"));
			EpoctiAntiAliaser aa = new EpoctiAntiAliaser(r, g, b, a, img);
			System.out.println("Now anti-aliasing...");
			// Create the file to write to
			File out = new File("out.png");
			// Anti-alias/write
			ImageIO.write(aa.antiAlias(), "png", out);
			System.out.println("Done anti-aliasing");
		} catch(java.io.IOException e){
			System.out.println("whoops");
			e.printStackTrace();
		}
	}
}
