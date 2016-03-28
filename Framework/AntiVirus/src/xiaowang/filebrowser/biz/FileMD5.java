package xiaowang.filebrowser.biz;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileMD5 {
	
	public String md5;
	public FileMD5(String path) throws IOException{
		this.md5= fileMD5(path);
	}
	public String getMd5() {
		return md5;
	}
	public static String fileMD5(String inputFile) throws IOException {
		// ��������С��������Գ��һ��������
		int bufferSize = 256 * 1024;
		FileInputStream fileInputStream = null;
		DigestInputStream digestInputStream = null;
		try {
			// �õ�һ��MD5ת������ͬ����������Ի���SHA1��
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// ʹ��DigestInputStream
			fileInputStream = new FileInputStream(inputFile);
			digestInputStream = new DigestInputStream(fileInputStream,messageDigest);
			// read�Ĺ����н���MD5����ֱ�������ļ�
			byte[] buffer = new byte[bufferSize];
			while (digestInputStream.read(buffer) > 0);
			// ��ȡ���յ�MessageDigest
			messageDigest = digestInputStream.getMessageDigest();
			// �õ������Ҳ���ֽ����飬����16��Ԫ��
			byte[] resultByteArray = messageDigest.digest();
			// ͬ�������ֽ�����ת�����ַ���
			return byteArrayToHex(resultByteArray);
		} catch (NoSuchAlgorithmException e) {
			return null;
		} finally {
			try {
				digestInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				fileInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ��������������ڽ��ֽ����黻�ɳ�16���Ƶ��ַ���
	public static String byteArrayToHex(byte[] byteArray) {
		// ���ȳ�ʼ��һ���ַ����飬�������ÿ��16�����ַ�
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		// newһ���ַ����飬�������������ɽ���ַ����ģ�����һ�£�һ��byte�ǰ�λ�����ƣ�Ҳ����2λʮ�������ַ���2��8�η�����16��2�η�����
		char[] resultCharArray = new char[byteArray.length * 2];
		// �����ֽ����飬ͨ��λ���㣨λ����Ч�ʸߣ���ת�����ַ��ŵ��ַ�������ȥ
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		// �ַ�������ϳ��ַ�������
		return new String(resultCharArray);
	}
}
