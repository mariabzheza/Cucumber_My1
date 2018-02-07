package Transformation;

import cucumber.api.Transformer;

/**
 * Created by Masha on 02.02.2018.
 */
public class EmailTransform extends Transformer<String> {

    @Override
    public String transform(String userName) {
        return userName.concat("@ea.com");
    }
}

