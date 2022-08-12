package ptit.example.tttnapplication.dto.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderPaginationResponse {
    List<OrderDetailResponse> billContent = new ArrayList<>();

    private int pageNo;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean last;
}
