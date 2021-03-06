// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/ConstantResultTransformationX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer;

import com.linkedin.dagli.annotation.equality.ValueEquality;
import com.linkedin.dagli.preparer.PreparerContext;
import com.linkedin.dagli.preparer.TrivialPreparer1;
import com.linkedin.dagli.preparer.Preparer1;
import com.linkedin.dagli.producer.Producer;
import java.util.Objects;


/**
 * A trivial implementation of a preparable transformer that ignores its inputs and provides a constant result.
 *
 * @param <A> the type of the first input
 *
 * @param <R> the type of the constant result that will be returned by the prepared transformer.
 */
@ValueEquality
public final class ConstantResultTransformation1<A, R>
    extends
    AbstractPreparableTransformer1<A, R, ConstantResultTransformation1.Prepared<A, R>, ConstantResultTransformation1<A, R>>
    implements ConstantResultTransformation<R, ConstantResultTransformation1<A, R>> {
  private static final long serialVersionUID = 1;

  // the object instance that will be the constant result of this transformer
  private R _resultForNewData = null;
  private R _resultForPreparationData = null;

  /**
   * Creates a new constant result preparable transformer that will ignore its inputs and will always has a null result.
   */
  public ConstantResultTransformation1() {
  }

  @Override
  protected boolean hasAlwaysConstantResult() {
    return true;
  }

  @Override
  protected boolean hasIdempotentPreparer() {
    return true;
  }

  /**
   * Returns a copy of this transformer that will always have the specified constant result object for both new and
   * preparation data.  Note that this exact object will be returned every time the transformer is applied (and not a
   * clone).
   *
   * @param result the result that will always be returned by this transformer
   * @return a copy of this transformer that will always have the specified constant result
   */
  public ConstantResultTransformation1<A, R> withResult(R result) {
    return clone(c -> {
      c._resultForNewData = result;
      c._resultForPreparationData = result;
    });
  }

  /**
   * Returns a copy of this transformer that will always have the specified constant result object for preparation data.
   * Note that this exact object will be returned every time the transformer is applied (and not a clone).
   *
   * @param result the result that will always be returned by this transformer for preparation data
   * @return a copy of this transformer that will always have the specified constant result
   */
  public ConstantResultTransformation1<A, R> withResultForPreparationData(R result) {
    return clone(c -> {
      c._resultForPreparationData = result;
    });
  }

  /**
   * Returns a copy of this transformer that will always have the specified constant result object for new data.
   * Note that this exact object will be returned every time the transformer is applied (and not a clone).
   *
   * @param result the result that will always be returned by this transformer for new data
   * @return a copy of this transformer that will always have the specified constant result
   */
  public ConstantResultTransformation1<A, R> withResultForNewData(R result) {
    return clone(c -> {
      c._resultForNewData = result;
    });
  }

  /**
   * @return the object instance that will be produced by this transformer for all new examples.
   */
  public R getResultForNewData() {
    return _resultForNewData;
  }

  /**
   * @return the object instance that will be produced by this transformer for all preparation examples.
   */
  public R getResultForPreparationData() {
    return _resultForPreparationData;
  }

  @Override
  protected Preparer1<A, R, ConstantResultTransformation1.Prepared<A, R>> getPreparer(PreparerContext context) {
    ConstantResultTransformation1.Prepared<A, R> resultForPrepData =
        new ConstantResultTransformation1.Prepared<A, R>(_resultForPreparationData);
    return _resultForPreparationData == _resultForNewData
        ? new TrivialPreparer1<>(resultForPrepData)
        : new TrivialPreparer1<>(resultForPrepData, new ConstantResultTransformation1.Prepared<A, R>(_resultForNewData));
  }

  public ConstantResultTransformation1<A, R> withInput(Producer<? extends A> inputA) {
    return super.withInput1(inputA);
  }

  @Override
  public String getName() {
    return "ConstantResultTransformation1("
        + (Objects.equals(_resultForNewData, _resultForPreparationData) ? _resultForNewData : ("prep = "
            + _resultForPreparationData + ", new = " + _resultForNewData)) + ")";
  }

  /**
   * A trivial implementation of a prepared transformer that ignores its inputs and provides a constant result.
   *
  * @param <A> the type of the first input
   * @param <R> the type of the constant result that will be returned by the transformer.
   */
  @ValueEquality
  public static final class Prepared<A, R> extends
      AbstractPreparedTransformer1<A, R, ConstantResultTransformation1.Prepared<A, R>> implements
      ConstantResultTransformation.Prepared<R, ConstantResultTransformation1.Prepared<A, R>> {
    private static final long serialVersionUID = 1;

    // the object instance that will be the constant result of this transformer
    private R _result = null;

    @Override
    protected boolean hasAlwaysConstantResult() {
      return true;
    }

    /**
     * Creates a new trivial prepared transformer that will ignore its inputs and always have a null result.
     */
    public Prepared() {
    }

    /**
     * Creates a new trivial prepared transformer that will ignore its inputs and always have the given result.
     *
     * @param result the result to be "produced"
     */
    public Prepared(R result) {
      _result = result;
    }

    /**
     * Returns a copy of this transformer that will always have the specified constant result object.  Note that this
     * exact result object will be returned every time the transformer is applied (and not a clone).
     *
     * @param result the result that will always be returned when applying the transformer
     * @return a copy of this transformer that will always have the specified constant result
     */
    public ConstantResultTransformation1.Prepared<A, R> withResult(R result) {
      return clone(c -> c._result = result);
    }

    /**
     * Gets the object instance that will be produced by this transformer for all inputs.
     *
     * @return the object instance that will be produced by this transformer for all inputs.
     */
    public R getResult() {
      return _result;
    }

    @Override
    public R apply(A value1) {
      return _result;
    }

    public ConstantResultTransformation1.Prepared<A, R> withInput(Producer<? extends A> inputA) {
      return super.withInput1(inputA);
    }

    @Override
    public String getName() {
      return "ConstantResultTransformation1.Prepared(" + _result + ")";
    }
  }
}
