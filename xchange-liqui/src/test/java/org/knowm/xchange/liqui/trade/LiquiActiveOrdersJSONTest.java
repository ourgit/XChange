package org.knowm.xchange.liqui.trade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.liqui.dto.LiquiTradeType;
import org.knowm.xchange.liqui.dto.trade.LiquiOrderInfo;
import org.knowm.xchange.liqui.dto.trade.result.LiquiActiveOrdersResult;
import org.knowm.xchange.liqui.marketdata.LiquiTickerJSONTest;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LiquiActiveOrdersJSONTest {

    @Test
    public void testUnmarshall() throws Exception {
        final InputStream is = LiquiTickerJSONTest.class.getResourceAsStream("/trade/example-activeorders-data.json");

        final ObjectMapper mapper = new ObjectMapper();
        final LiquiActiveOrdersResult activeOrdersResult = mapper.readValue(is, LiquiActiveOrdersResult.class);
        assertThat(activeOrdersResult.isSuccess()).isTrue();

        final Map<Long, LiquiOrderInfo> orders = activeOrdersResult.getResult();
        final LiquiOrderInfo order = orders.get(108998425L);
        assertThat(order).isNotNull();

        assertThat(order.getPair()).isEqualTo(new CurrencyPair("trx", "btc"));
        assertThat(order.getType()).isEqualTo(LiquiTradeType.SELL);
        assertThat(order.getAmount()).isEqualTo(new BigDecimal("1.0"));
        assertThat(order.getRate()).isEqualTo(new BigDecimal("0.0001"));
        assertThat(order.getTimestampCreated()).isEqualTo(1500000000L);
    }
}
