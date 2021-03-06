package com.deliveredtechnologies.rulebook.runner;

import com.deliveredtechnologies.rulebook.Fact;
import com.deliveredtechnologies.rulebook.RuleState;
import com.deliveredtechnologies.rulebook.annotation.Given;
import com.deliveredtechnologies.rulebook.annotation.Result;
import com.deliveredtechnologies.rulebook.annotation.Rule;
import com.deliveredtechnologies.rulebook.annotation.Then;
import com.deliveredtechnologies.rulebook.annotation.When;

import java.util.List;
import java.util.Set;

/**
 * Created by clong on 2/13/17.
 * Sample POJO rule with facts and a result.
 */
@Rule(order = 2)
public class SampleRuleWithResult {
  @Given("fact1")
  private Fact<String> _fact1;

  @Given("fact2")
  private Fact<String> _fact2;

  @Given
  private List<String> _strList;

  @Given("value1")
  private int _value1;

  @Given
  private Set<Integer> _valueSet;

  @Given
  private List<Integer> _valueList;

  @Result
  private String _result;

  @When
  public boolean when() {
    return _fact1.getValue().equals(_fact2.getValue());
  }

  /**
   * Method then() performs the rule's action.
   * @return  RuleState.NEXT to continue to the next rule in the chain
   */
  @Then
  public RuleState then() {
    _fact2.setValue("So Factual Too!");
    _fact1.setValue("So Factual Too!");
    _result = "Equivalence, Bitches!";
    return RuleState.NEXT;
  }

  public String getFact1() {
    return _fact1.getValue();
  }

  public String getFact2() {
    return _fact2.getValue();
  }

  public List<String> getStrList() {
    return _strList;
  }

  public int getValue1() {
    return _value1;
  }

  public Set<Integer> getValueSet() {
    return _valueSet;
  }

  public List<Integer> getValueList() {
    return _valueList;
  }

  public String getResult() {
    return _result;
  }
}
