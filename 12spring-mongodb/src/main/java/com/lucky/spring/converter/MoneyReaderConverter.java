package com.lucky.spring.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * Created by zhangdd on 2020/8/8
 * <p>
 * 处理将Document 转换成 Money
 */
public class MoneyReaderConverter implements Converter<Document, Money> {

    @Nullable
    @Override
    public Money convert(Document source) {
        //取数据
        Document money = (Document) source.get("money");
        //从获取的数据中取对应的字段
        double amount = Double.parseDouble(money.getString("amount"));
        String currency = ((Document) money.get("currency")).getString("code");

        //将获取的业务字段进行类型转换
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
