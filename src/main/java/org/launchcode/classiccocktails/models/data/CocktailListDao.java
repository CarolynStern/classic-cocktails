package org.launchcode.classiccocktails.models.data;

import org.launchcode.classiccocktails.models.CocktailList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CocktailListDao extends CrudRepository<CocktailList, Integer> {
}
