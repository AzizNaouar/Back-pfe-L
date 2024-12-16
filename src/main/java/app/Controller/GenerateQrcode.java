package app.Controller;

import java.io.ByteArrayOutputStream;

import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import app.Modele.Response;

@RestController
public class GenerateQrcode 
{
	@CrossOrigin
	@GetMapping(value = "/genrateQRCode/{code}")
   	public Response generateQRCode(@PathVariable("code") String code)
   		    throws Exception {
		    QRCodeWriter qrCodeWriter = new QRCodeWriter();
		    BitMatrix bitMatrix = qrCodeWriter.encode(code, BarcodeFormat.QR_CODE, 60, 60);
		    
		    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray(); 
		    String qr=new String(Base64Utils.encodeToString(pngData) );
		    Response response=new Response(qr);
   		    return response;
   		        
   		    }
}
