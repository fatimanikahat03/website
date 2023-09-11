resource "aws_instance" "my-machine" {
  count = 4     
  ami = var.ami
  instance_type = var.instance_type
  tags = {
    Name = "my-machine-${count.index}"
         }
}
