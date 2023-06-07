package pt.isec.pa.apoio_poe.model.data;

public interface IMemento {
        default PoE getSnapshot(){return null;}
}

