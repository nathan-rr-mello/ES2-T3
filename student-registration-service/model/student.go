package model

type Student struct {
	Id      uint   `json:"id"`
	Name    string `json:"name"`
	RG      string `json:"rg"`
	Address string `json:"address"`
}
