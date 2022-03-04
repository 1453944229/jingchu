package com.jingchu.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author pc
 * creat 2021/11/2-16:32
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Count {

    private Integer id;

    private Integer loadnum;

    private Integer unloadnum;

    private Date localDate;

}
