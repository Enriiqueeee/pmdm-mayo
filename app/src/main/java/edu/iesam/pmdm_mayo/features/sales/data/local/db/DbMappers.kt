package edu.iesam.pmdm_mayo.features.sales.data.local.db

import edu.iesam.pmdm_mayo.features.sales.model.Sales


fun Sales.toEntity(): SaleEntity {
    return SaleEntity(
        id = 0,
        this.dni,
        this.conceptSales,
        this.totalSales
    )
}



fun SaleEntity.toDomain(): Sales {
    return Sales(
        this.dni,
        this.conceptSales,
        this.totalSales
    )
}
