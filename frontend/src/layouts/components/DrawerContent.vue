<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: 'Order' }" />
        <VerticalNavLink
            :item="{
                title: 'Order',
                to: '/orders',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'OrderItem',
                to: '/orderItems',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'GetOrderItem',
                to: '/getOrderItems',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Inventory' }" />
        <VerticalNavLink
            :item="{
                title: 'Inventory',
                to: '/inventories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'GetInventory',
                to: '/getInventories',
            }"
        />
    </ul>
</template>
