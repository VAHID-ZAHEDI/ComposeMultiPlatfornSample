package org.example.project.presentation.component

import androidx.compose.runtime.snapshots.SnapshotStateList
import org.example.project.domain.CurrencyPrices

class CardListState(val list: SnapshotStateList<CurrencyPrices>) {
    fun onSelected(isSelected: Boolean, item: CurrencyPrices) {
        val iterator = list.listIterator()
        while (iterator.hasNext()) {
            val obj = iterator.next()

            if (obj.id != item.id) {
                iterator.set(obj.copy(isExpanded = false))
            } else {
                iterator.set(obj.copy(isExpanded = isSelected))
            }

        }
    }
}