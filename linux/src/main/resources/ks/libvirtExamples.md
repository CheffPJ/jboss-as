> wget -P ~/Downloads http://download.fedoraproject.org/pub/fedora/linux/releases/15/Fedora/x86_64/os/images/boot.iso

> sudo virt-install --noautoconsole --cdrom=~/Downloads/boot.iso --name=as7-02 --disk /var/lib/libvirt/images/as7-02.img,size=5 --vcpus=1 --ram=1024 --location="http://mirrors.kernel.org/fedora//releases/15/Fedora/x86_64/os" --os-type=linux --os-variant=fedora14 --extra-args="ks=http://people.redhat.com/~pmcdonou/src/ks/f15-white-rabbit-ks.cfg"
