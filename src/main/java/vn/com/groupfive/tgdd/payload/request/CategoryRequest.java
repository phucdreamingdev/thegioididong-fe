package vn.com.groupfive.tgdd.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
	private String name;
	
	private String logo;
	
	private int level;
	
	private String parentName;

	private boolean status;

	private boolean isParent;
	
	private int childrenLevel;
}
