package test.ashishjaintechg.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
	
	private int id;
	private String name;
	private float discount;
	
	
	public static Coupon getCouponByCode(String code) {
		Coupon c1 = new Coupon();
		c1.setId(101);
		c1.setName(code);
		c1.setDiscount(10.0f);
		return c1;
	}
	
	
}
