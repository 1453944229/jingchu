package com.jingchu.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author pc
 * creat 2021/11/12-16:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Corporation {
    private Integer id;

    private String corpName;

    private String corpPosition;

    private Integer corEmployeeNum;

    private String corLicence;

    private Date startDate;

    private Date endDate;
}


