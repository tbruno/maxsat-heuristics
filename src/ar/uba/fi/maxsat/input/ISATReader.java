package ar.uba.fi.maxsat.input;

import ar.uba.fi.maxsat.domain.SATProblem;

public interface ISATReader {

	SATProblem readFile(String path);
}
