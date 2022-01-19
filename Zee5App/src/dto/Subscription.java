package dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Subscription {
	 private String id;
	 private String type;
	 private String dop;
	 private String status;
	 private String country;
	 private String paymentmode;
	 private String autorenewal;
	 private String doe;
	 
	 
}
