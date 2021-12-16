package com.investment.services;

import com.investment.forms.BondForm;
import com.investment.models.Bond;

/**
 * Интерфейс сервиса для работы с облигациями (Bond)
 * Наследует интерфейс сервиса для работы с ценными бумагами (Paper)
 * @author Илья Петров
 * @version 1.0
 */
public interface BondService extends PaperService<BondForm, Bond> {
}
