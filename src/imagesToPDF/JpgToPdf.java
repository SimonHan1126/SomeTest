package imagesToPDF;

/**
 * @author Simon-the-coder
 * @date 12/12/21 6:04 PM
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JpgToPdf {
    public static void main(String arg[]) throws Exception {
        String rootPath = "/Users/simon-youtap/Documents/github/flutter-tips-and-tricks/tipsandtricks/";
        File root = new File(rootPath);
        String outputFile = "flutterTipsImages.pdf";

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File(root, outputFile)));
        document.open();

        File[] fa = root.listFiles();
        List<String> imageNameList = new ArrayList<>();
        for (File file : fa) {
            if (file.isDirectory()) imageNameList.add(file.getName());
        }
        System.out.println("imageNameList.size() ===> " + imageNameList.size());
        Collections.sort(imageNameList);
        int count = 0;
        for (String imageName : imageNameList) {

            File file = new File(rootPath + imageName + "/" + imageName + ".jpg");
            if (file.exists()) {
                imageName = imageName + "/" + imageName + ".jpg";
            } else {
                imageName = imageName + "/" + imageName + ".jpeg";
            }

            document.newPage();
            Image image = Image.getInstance(new File(root, imageName).getAbsolutePath());
            float aspectRatio = image.getWidth() / image.getHeight();
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin()) / image.getWidth());
            if (aspectRatio >= 1.414) {
                scaler = ((document.getPageSize().getHeight() - document.leftMargin() - document.rightMargin()) / image.getWidth());
                image.setRotationDegrees(90);
                float scaledWidth = image.getWidth() * scaler;
                document.left((document.getPageSize().getWidth() - scaledWidth) / 2);
            } else {
                float scaledHeight = image.getHeight() * scaler;
                document.top((document.getPageSize().getHeight() - scaledHeight) / 2);
            }
            image.scalePercent(scaler * 100);
            System.out.println("aspectRatio " + aspectRatio + " scaler " + scaler + " Current Image Name ===> " + imageName + " image.width " + image.getWidth() + " image.height " + image.getHeight());
            document.add(image);
            count++;
        }
        System.out.println("document.getPageSize().getWidth() " + document.getPageSize().getWidth());
        System.out.println("document.getPageSize().getHeight() " + document.getPageSize().getHeight());
        System.out.println("document.leftMargin() " + document.leftMargin());
        System.out.println("document.rightMargin() " + document.rightMargin());
        System.out.println("document.topMargin() " + document.topMargin());
        System.out.println("document.bottomMargin() " + document.bottomMargin());

        document.close();
        System.out.println("DONE ----- count = " + count);
    }
}
