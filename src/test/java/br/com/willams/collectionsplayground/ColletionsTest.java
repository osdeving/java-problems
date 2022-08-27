package br.com.willams.collectionsplayground;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ColletionsTest {
	static List<String> list = List.of("aa", "bb", "cc", "dd", "bb");

	@Test
	@DisplayName("When collecting to list should collect to list")
	void whenCollectingToList_shouldCollectToList() { 
		var result = list.stream().collect(toList());

		assertThat(result).containsAll(list);
	}

	@Test
	@DisplayName("When collecting to unmodifiable list should collect to un modifiable list")
	void whenCollectingToUnmodifiableList_shouldCollectToUnmodifiableList() { 
		final var result = list.stream().collect(toUnmodifiableList());

		assertThatThrownBy(() -> result.add("foor")).isInstanceOf(UnsupportedOperationException.class);
	}
	
	@Test
    public void whenCollectingToCollection_shouldCollectToCollection() throws Exception {
		final var result = list.stream().collect(toCollection(LinkedList::new));

        assertThat(result).containsAll(list).isInstanceOf(LinkedList.class);
    }

	@Test
	@DisplayName("Teste do collector toMap com duplicatas resolvendo qual deve usar")
	public void quando_coletar_toMap_com_duplicatas_entao_deve_coletar_mesclando_itens_iguais() {

		var listaComDuplicatas = List.of("a", "bbb", "c", "d", "bbb");
		
		final var result = listaComDuplicatas
			.stream()
			.collect(
				toMap( 
					Function.identity(),
					String::length,
					 (item, itemIgual) -> item 
				)
		);

		assertThat(result)
			.containsEntry("a", 1)
			.containsEntry("bbb", 3)
			.containsEntry("b", 1)
			.containsEntry("c", 1)
			.containsEntry("d", 1);
	}

	Function<String, String> ff;

	
}
