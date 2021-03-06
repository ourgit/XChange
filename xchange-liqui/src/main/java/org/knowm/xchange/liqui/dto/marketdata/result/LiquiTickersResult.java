package org.knowm.xchange.liqui.dto.marketdata.result;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.knowm.xchange.liqui.dto.marketdata.LiquiResult;
import org.knowm.xchange.liqui.dto.marketdata.LiquiTicker;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiquiTickersResult extends LiquiResult<Map<String, LiquiTicker>> {

    @JsonCreator
    public LiquiTickersResult(final Map<String, LiquiTicker> tickers) {
        super(tickers, null);
    }
}
