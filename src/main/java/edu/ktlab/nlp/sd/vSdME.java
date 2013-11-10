package edu.ktlab.nlp.sd;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class vSdME {
	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("models/SD/vi-sd.model");
		SentenceModel sentdetectModel = new SentenceModel(in);
		SentenceDetector sd = new SentenceDetectorME(sentdetectModel);
		String[] sents = sd.sentDetect("(Ảnh minh họa: PV/Vietnam+) “Trong khi các tập đoàn đa quốc gia có mức tăng lương bình quân cho nhân viên là 11,1 % thì các công ty trong nước có mức tăng lương nhỉnh hơn một chút 11,3%,” bà Nguyễn Hoa cho biết. Đây là nhận định được đưa ra tại buổi công bố kết quả khảo sát lương tại Việt Nam năm 2013 do Công ty tư vấn về nhân sự Mercer và đại diện tại Việt Nam - Talentnet tổ chức ngày 17/10 tại Hà Nội. Theo kết quả khảo sát, đa số các công ty tham gia khảo sát (71%) đều thực hiện chế độ trả lương tháng thứ 13, có 3% trả thêm lương tháng thứ 4, còn lại là số ít trả lương đủ 12 tháng hoặc thực hiện các chế độ trả lương khác. Tỷ lệ trả lương tháng thứ 13 không thay đổi đối với các công ty nước ngoài tuy nhiên các trong số công ty trong nước tham gia khảo sát thì tỷ lệ này đã giảm hơn so với năm ngoái 15% và thay vào đó là trả 12 tháng hoặc bằng hình thức trả lương khác. Bên cạnh đó, kết quả khảo sát cho thấy, việc kiểm soát quỹ lương thưởng như thế nào cho tiết kiệm và hiệu quả cũng là điều các doanh nghiệp đặt quan tâm lên hang đầu. Các công ty vẫn cố gắng đảm bảo các chính sách lương bổng, phúc lợi để thu hút và giữ chân nhân tài một cách hiệu quả, đặc biệt là đối với các cấp quản lý và lãnh đạo. Kết quả khảo sát theo cụ thể từng ngành nghề cho thấy, dược phẩm, sản xuất và hàng tiêu dùng là 3 lĩnh vực không bị ảnh hưởng nhiều bởi sự biến động của nền kinh tế, vì vậy đây là ba ngành vẫn duy trì được tỷ lệ tăng lương cao nhất qua các năm và năm nay là 12%. Trong khi đó, các ngành dịch vụ tài chính, ngân hàng và bất động sản có tỷ lệ tăng lương thấp nhất, phản ánh rất rõ mức độ ảnh hưởng bởi sự biến động của nền kinh tế trong nằm vừa qua. Xét về tỷ lệ nghỉ việc, tình hình kinh tế thay đổi khiến cả chủ doanh nghiệp và người lao động thận trọng hơn trong vấn đề tuyển dụng mới và thay đổi công việc. Vì vậy, nhìn chung, tỷ lệ nghỉ việc năm nay có giảm khoảng 2-3 % so với năm ngoái trong tất cả các ngành nghề. Tỷ lệ nghỉ việc cao nhất trong hai năm gần đây là ngành công nghệ cao. Nguyên nhân là do ngành này được đánh giá là một ngành “đang lên” và sự thiếu hụt những nhân sự giỏi, có kỹ năng chuyên môn cao dẫn đến những biến động về nhân sự ngành này trong những năm gần đây. Năm 2013 cũng là năm đầu tiên các công ty trong lĩnh vực công nghệ tham gia khảo sát đông đảo nhất cho thấy sự chuyển hướng đầu tư và tập trung về nhân sự của lĩnh vực này. Tương tự như năm trước, sự ổn định nhất về nhân sự vẫn là ở ngành dầu khí với tỷ lệ nghỉ việc thấp nhất trong toàn thị trường là 6,3%. Sự ổn định này là do tính chất đặc thù về nhân sự và phát triển ổn định của ngành. Về tình hình tuyển dụng và cắt giảm nhân sự, có 3% doanh nghiệp tham gia khảo sát cho biết sẽ cắt giảm nhân sự và số lượng các doanh nghiệp quyết định tuyển dụng thêm đã giảm còn 60% so với 68% của năm 2012. Các vị trí: Trưởng phòng kinh doanh, chuyên viên kinh doanh và trưởng phòng tiếp thị vẫn là các công việc được săn đón nhiều nhất, nằm trong nhóm 3 công việc các công ty khó tuyển dụng và giữ nhân tài nhất trong các năm qua./. Cuộc khảo sát lương tại Việt Nam năm 2013 đã thu hút 418 công ty đến từ nhiều lĩnh vực, ngành nghề khác nhau tham gia và thu thập dữ liệu lương thưởng từ 1.572 vị trí của hơn 142.587 nhân viên trên khắp Việt Nam. Số lượng các công ty tham gia khảo sát năm 2013 tăng so với năm 2012 và có xu hướng ngày càng tăng chứng tỏ rằng hiện nay ngày càng nhiều các công ty xem xét hệ thống lương thưởng một cách nghiêm túc./ . Hồng Kiều (Vietnam+)");
		for (String sent : sents)
			System.out.println(sent);
				
	}

}
