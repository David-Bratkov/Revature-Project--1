export interface Pokemon{
    id: number;
    name: string;
    sprites: {
        front_shiny: string
    }
    abilities: Array<{
        ability: {
            name: string
        }
    }>
}