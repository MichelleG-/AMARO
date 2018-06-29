package teste.amaro.domain.builder;

import teste.amaro.domain.mapper.Mapper;
import teste.amaro.domain.transferobject.TransferObject;

public interface BuilderMapper<In extends TransferObject, Out extends Mapper>
{
    Out build(In in);
}
