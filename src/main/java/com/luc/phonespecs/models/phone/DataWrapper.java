package com.luc.phonespecs.models.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataWrapper {
    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("phones")
    private List<BrandPhones> brandPhones;

    @JsonProperty("last_page")
    private int lastPage;

}
