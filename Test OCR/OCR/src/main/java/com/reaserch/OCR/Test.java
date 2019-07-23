


package com.reaserch.OCR;
import java.io.File;
import java.io.IOException;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import net.sourceforge.tess4j.TesseractException;

public class Test {

	private static void showWaitDestroy(String winname, Mat img) {
		HighGui.imshow(winname, img);
		HighGui.moveWindow(winname, 500, 0);
		HighGui.waitKey(0);		
		HighGui.destroyWindow(winname);

	}


	public static void main(String[] args) throws IOException, TesseractException {


	 // Load the OpenCV Library	
		nu.pattern.OpenCV.loadShared();

	// load the image
		Mat src = Imgcodecs.imread("C:\\Users\\Damith Jayawardhane\\Desktop\\1.jpg");
		
	// Grayscale the image
		Mat gray = new Mat();
		Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
		showWaitDestroy("Gray Image", gray);

	// Threshold the image
		Mat threshold = new Mat();
		Imgproc.adaptiveThreshold(gray, threshold, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY,(2 * 15) + 1, 15);
		showWaitDestroy("Threshold Image", threshold);

		
		System.out.print("Output: "); 
		
		writeCroppedImage(threshold); 
		
		System.exit(0);

	}
	
	public static void writeCroppedImage(Mat threshold) throws IOException, TesseractException {
		
		File imageFile = new File("C:\\test\\1-tresh.jpg");
		
		Imgcodecs.imwrite(imageFile.getPath(), threshold);
		
		String command="tesseract "+imageFile.getPath()+" "+imageFile.getParentFile().getPath()+"\\out -l sin";
		
		System.out.println(command);
		
		Runtime.getRuntime().exec(command);
		
	}
}