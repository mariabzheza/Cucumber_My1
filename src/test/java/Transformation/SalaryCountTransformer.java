package Transformation;

import cucumber.api.Transformer;

/**
 * Created by Masha on 02.02.2018.
 */
public class SalaryCountTransformer extends Transformer<Integer> {
    @Override
    public Integer transform(String salary) {
        return salary.length();
    }
}
