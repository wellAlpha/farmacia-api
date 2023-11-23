
INSERT IGNORE INTO cargo (nome) VALUES 
('Administrador'),
('Farmacêutico'),
('Vendedor');


INSERT IGNORE INTO tipo_medicacao (descricao) VALUES 
('Analgésico'),
('Antibiótico'),
('Antiviral'),
('Anti-inflamatório'),
('Antidepressivo'),
('Antipsicótico'),
('Anticonvulsivante'),
('Antipirético'),
('Anti-hipertensivo'),
('Anticoagulante'),
('Hormônio'),
('Imunossupressor'),
('Quimioterápico'),
('Anti-histamínico'),
('Broncodilatador'),
('Antiácido'),
('Antifúngico'),
('Antiemético'),
('Anti-histamínico'),
('Expectorante'),
('Outros');

INSERT IGNORE INTO composicao (descricao) VALUES 
('Paracetamol'),
('Amoxicilina'),
('Oseltamivir'),
('Ibuprofeno'),
('Fluoxetina'),
('Risperidona'),
('Valproato de Sódio'),
('Paracetamol'),
('Losartan'),
('Varfarina'),
('Insulina'),
('Ciclosporina'),
('Metotrexato'),
('Loratadina'),
('Albuterol'),
('Omeprazol'),
('Clotrimazol'),
('Ondansetrona'),
('Cetirizina'),
('Guaifenesina');


INSERT IGNORE INTO categoria_produto (descricao) VALUES 
('Cosmético'),
('Produtos de Higiene Pessoal'),
('Suplemento Vitamínico'),
('Alimentos Saudáveis'),
('Produtos para Cuidado Capilar'),
('Acessórios de Higiene Bucal'),
('Dispositivos Médicos'),
('Cuidado com a Pele'),
('Produtos para Bebês e Crianças'),
('Artigos para Cuidado Feminino'),
('Equipamentos de Primeiros Socorros'),
('Produtos de Bem-Estar'),
('Artigos de Conveniência'),
('Produtos para Diabéticos'),
('Ortopédicos'),
('Produtos para Cuidado Ocular'),
('Artigos para Cuidado com os Pés'),
('Produtos para Saúde Sexual'),
('Testes de Gravidez e Ovulação'),
('Outros');


INSERT IGNORE INTO tipo_conteudo (descricao, sigla)
VALUES
  ('Comprimidos', 'CP'),
  ('Mililitros', 'ML'),
  ('Miligramas', 'MG'),
  ('Microgramas', 'MCG'),
  ('Cápsulas', 'CAP'),
  ('Drágeas', 'DRG'),
  ('Gotas', 'GT'),
  ('Unidades', 'UN');