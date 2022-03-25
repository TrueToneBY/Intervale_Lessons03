package com.intervale.cources.library.external.alfabank.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@Validated
@Schema(description = "Стоимость в различных валютах для книги с указанным названием.")
public class BookWithCurrencies {
    @NotBlank
    private String name;
    @NonNull
    private Map<String, BigDecimal> prices;
}
