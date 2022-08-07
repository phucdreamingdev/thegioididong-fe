package vn.com.groupfive.tgdd.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchesRequest {
	private String address;

	private boolean status;

	private Long wardId;
}
