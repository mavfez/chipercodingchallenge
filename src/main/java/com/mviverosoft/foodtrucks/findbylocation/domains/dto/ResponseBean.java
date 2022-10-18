package com.mviverosoft.foodtrucks.findbylocation.domains.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBean<T extends Serializable> extends BaseBean implements Serializable {

    private static final long serialVersionUID = 2076140798235745183L;

    T body;
    boolean hasErrors = false;
    String message;

    public ResponseBean() {
        super();
    }

}
