package vn.com.groupfive.tgdd.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequest {
	private String name;
	private boolean isActived;
	private Long categoryId;
	private Long manufacturerId;
}
