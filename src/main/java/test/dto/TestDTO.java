package test.dto;

import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestDTO {

    private String title;
    private Integer value;
    private Integer q1;
    private Integer q2;
    private Integer q3;
    private Integer q4;
    private String id;
    private String[] ids;
    private String quarter;
    private ArrayList<String> segments;
    private ArrayList<String> campaigns;
    private String status;
    private String createdBy;
    private Date created;
    private String modifiedBy;
    private Date modified;
    private Integer year;
    private String level1;
    private String level2;
    private String level3;
    private String costCenter;
    private String ownerId;
    private String parentManagerId;
    private String managerId;
    private String budgetType;
    private boolean useInCoupa;
    private boolean useInTableau;
    private boolean isPaidMedia;
    private String email;
    private String successIds;

    public TestDTO() {
    }
}
