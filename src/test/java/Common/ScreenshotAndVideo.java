package Common;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.monte.media.VideoFormatKeys.*;

public class ScreenshotAndVideo extends ScreenRecorder{

	public static ScreenRecorder screenRecorder;
	public String name;
	public static String screenShotBySelenium(WebDriver driver, String imgPath) {
		try {
			String pathSave = Constans.folderReprotLocation;
			// Tạo tham chiếu của TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            // Gọi hàm capture screenshot - getScreenshotAs
            File imgSelenium = ts.getScreenshotAs(OutputType.FILE);
            File saveImg = new File(pathSave+imgPath);
        	FileUtils.copyFile(imgSelenium, saveImg);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Capture selenium fail "+e.getMessage());
		}
		return imgPath;
	}

	public static String screenShotByJava(String imgPath) {
		try {
			String pathSave = Constans.folderReprotLocation;
			Robot robot = new Robot();
			Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
	        File oDest = new File(pathSave + imgPath);
	        File directory = new File(oDest.getParent());
	        if (!directory.exists()){
	            directory.mkdirs();
	        }
			ImageIO.write(bufferedImage, "jpg", oDest);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Capture screen By java fail "+e.getMessage());
		}
		return imgPath;
	}

	// start code video
	public ScreenshotAndVideo(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
                              Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
		this.name = name;
	}
	//Hàm này bắt buộc để ghi đè custom lại hàm trong thư viên viết sẵn
	@Override
	protected File createMovieFile(Format fileFormat) throws IOException {
		if (!movieFolder.exists()) {
			movieFolder.mkdirs();
		} else if (!movieFolder.isDirectory()) {
			throw new IOException("\"" + movieFolder + "\" is not a directory.");
		}
		return new File(movieFolder,
				name +"." + Registry.getInstance().getExtension(fileFormat));
	}
	// Hàm Start record video
		public static void startRecord(String methodName) throws Exception {
			String pathSave = Constans.folderReprotLocation+Constans.folderVideoReport;
			//Tạo thư mục để lưu file video vào
			File file = new File(pathSave);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;

			Rectangle captureSize = new Rectangle(0, 0, width, height);

			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration();
			screenRecorder = new ScreenshotAndVideo(gc, captureSize,
					new Format(FormatKeys.MediaTypeKey, MediaType.FILE, FormatKeys.MimeTypeKey, FormatKeys.MIME_AVI),
					new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FormatKeys.FrameRateKey,
							Rational.valueOf(15), QualityKey, 1.0f, FormatKeys.KeyFrameIntervalKey, 15 * 60),
					new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, "black", FormatKeys.FrameRateKey, Rational.valueOf(30)),
					null, file, methodName);
			screenRecorder.start();
		}

		// Stop record video
		public static void stopRecord() throws Exception {
			screenRecorder.stop();
		}

	public static ExtentReports Instance(ExtentReports extent, String screnario) {
		String Path = Constans.folderReprotLocation +screnario+ ".html";
		extent = new ExtentReports(Path, true);
		return extent;
	}
}
