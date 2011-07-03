> wget -P /tmp http://download.fedoraproject.org/pub/fedora/linux/releases/15/Fedora/x86_64/os/images/boot.iso

> sudo mkdir /tmp/f15-boot
> sudo mount -o loop /tmp/boot.iso /tmp/f15-boot

> sudo virt-install --noautoconsole --location=/tmp/f15-boot --name=as7-02 --disk /var/lib/libvirt/images/as7-02.img,size=5 --vcpus=1 --ram=1024 --os-type=linux --os-variant=fedora14 --extra-args="ks=http://people.redhat.com/~pmcdonou/src/ks/f15-white-rabbit-ks.cfg"
