package com.brovada;

import java.util.Optional;

public interface Input<T> extends Component {

    default Optional<InputType> getInputType() { return Optional.of(InputType.TEXT); }
    default boolean isRequired() { return true; };
    default Optional<T> defaultValue() { return Optional.empty(); }
    default Optional<T> order() { return Optional.empty(); }

//    { type:  label:  order:  required: id:  dropdownvalues:  defaultValue? validators:["required"] ,asyncValidator:[]  css: },
//    { type:  label:  order:  required: id:  dropdownvalues:
//    dependents :  [{ type: label: order : required: id:  when:[valueA,valueB,valueF] },
//        { type: label: order : required: id:  when:"valueB" }]
//        //any level of dependents...
//    }
//    { type:  label:  order:  required: id:  defaultValue:  autocompleteRestUrl:  otherNg2CompleterAttributes },
//    { type:  label:  order:  required: id:  defaultValue: inputType /* html5 type */},

}
