package com.jingchu.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author pc
 * creat 2021/11/2-16:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Summonth {

    private Integer loadnum;

    private Integer unloadnum;

    private String localDate;
}
