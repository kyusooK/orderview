<template>
    <div>
        <String
            label="ProductName"
            v-model="value.productName"
            :editMode="editMode"
        />
        <Number
            label="Price"
            v-model="value.price"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'OrderItem',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "orderItems",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
